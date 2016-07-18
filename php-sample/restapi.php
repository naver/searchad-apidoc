<?php

class RestApi
{
    protected $baseUrl;
    protected $apiKey;
    protected $secretKey;
    protected $customerId;

    function __construct($baseUrl, $apiKey, $secretKey, $customerId)
    {
        $this->baseUrl = $baseUrl;
        $this->apiKey = $apiKey;
        $this->secretKey = $secretKey;
        $this->customerId = $customerId;
    }

    protected function generateSignature($timestamp, $method, $path)
    {
        $sign = $timestamp . "." . $method . "." . $path;
        echo "sign = " . $sign . "\n";
        $signature = hash_hmac('sha256', $sign, $this->secretKey, true);
        return base64_encode($signature);
    }

    protected function getTimestamp()
    {
        return round(microtime(true) * 1000);
    }

    protected function getHeader($method, $uri)
    {
        $timestamp = $this->getTimestamp();
        $header = array(
            'Content-Type: application/json; charset=UTF-8',
            'X-Timestamp: ' . $timestamp,
            'X-API-KEY: ' . $this->apiKey,
            'X-Customer: ' . $this->customerId,
            'X-Signature: ' . $this->generateSignature($timestamp, $method, $uri),
        );
        return $header;
    }

    protected function build_http_query($query)
    {
        if (!empty ($query)) {
            $query_array = array();
            foreach ($query as $key => $key_value) {
                $query_array [] = urlencode($key) . '=' . urlencode($key_value);
            }

            return implode('&', $query_array);
        } else {
            return '';
        }
    }

    protected function get_transaction_id($header)
    {
        $header_rows = explode("\n", $header);
        for ($i = 0; $i < count($header_rows); $i++) {
            $fields = explode(":", $header_rows[$i]);
            if (count($fields) < 2) {
                continue;
            }
            $name = trim($fields[0]);
            $value = trim($fields[1]);
            if ("X-Transaction-ID" == $name) {
                return $value;
            }
        }

        return "unknown";
    }

    protected function parseResponse($response)
    {
        if (!empty ($response)) {
            $result = explode("\r\n\r\n", $response, 2);
            if (count($result) < 2) {
                echo "invalid response body! it has no HEADER and BODY!\n";
                return array();
            }
            $header = $result [0];
            $body = $result [1];
            $transactionId = $this->get_transaction_id($header);
            $jsonbody = json_decode($body, true);
            return array('transactionId' => $transactionId, 'json' => $jsonbody);
        }

        return array();
    }

    public function GET($uri, $query = array())
    {
        $ch = curl_init();
        if (!$ch) {
            die ("Couldn't initialize a cURL handle");
        }
        curl_setopt($ch, CURLOPT_URL, $this->baseUrl . $uri . (empty($query) ? '' : '?' . $this->build_http_query($query)));
        curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
        curl_setopt($ch, CURLOPT_HEADER, true);
        curl_setopt($ch, CURLOPT_HTTPHEADER, $this->getHeader('GET', $uri));

        $output = curl_exec($ch);
        $code = curl_getinfo($ch, CURLINFO_HTTP_CODE);
        $error = curl_error($ch);
        curl_close($ch);
        if (empty ($code)) {
            die ("No HTTP code was returned");
        } else {
            echo "Http Status : " . $code . "\n";
        }

        $response = $this->parseResponse($output);

        if (!empty ($error)) {
            echo "error : $error\n";
            die("failed to request");
        }
        echo "Transaction-ID : " . $response["transactionId"] . "\n";
        return $response["json"];
    }

    public function POST($uri, $data, $query = array())
    {
        $data_string = json_encode($data);
		echo "request : ". $data_string . "\n";
        $ch = curl_init();
        if (!$ch) {
            die ("Couldn't initialize a cURL handle");
        }
        curl_setopt($ch, CURLOPT_URL, $this->baseUrl . $uri . (empty($query) ? '' : '?' . $this->build_http_query($query)));
        curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
        curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "POST");
        curl_setopt($ch, CURLOPT_POST, true);
        curl_setopt($ch, CURLOPT_POSTFIELDS, $data_string);
        curl_setopt($ch, CURLOPT_HEADER, true);
        curl_setopt($ch, CURLOPT_HTTPHEADER, $this->getHeader('POST', $uri));

        $output = curl_exec($ch);
        $code = curl_getinfo($ch, CURLINFO_HTTP_CODE);
        $error = curl_error($ch);
        curl_close($ch);

        if (empty ($code)) {
            die ("No HTTP code was returned");
        } else {
            echo "Http Status : " . $code . "\n";
        }

        $response = $this->parseResponse($output);

        if (!empty ($error)) {
            echo "error : $error\n";
            die("failed to request");
        }
        echo "Transaction-ID : " . $response["transactionId"] . "\n";
        return $response["json"];
    }

    public function DELETE($uri, $query = array())
    {
        $ch = curl_init();
        if (!$ch) {
            die ("Couldn't initialize a cURL handle");
        }
        curl_setopt($ch, CURLOPT_URL, $this->baseUrl . $uri . (empty($query) ? '' : '?' . $this->build_http_query($query)));
        curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
        curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "DELETE");
        curl_setopt($ch, CURLOPT_HEADER, true);
        curl_setopt($ch, CURLOPT_HTTPHEADER, $this->getHeader('DELETE', $uri));

        $output = curl_exec($ch);
        $code = curl_getinfo($ch, CURLINFO_HTTP_CODE);
        $error = curl_error($ch);
        curl_close($ch);
        if (empty ($code)) {
            die ("No HTTP code was returned");
        } else {
            echo "Http Status : " . $code . "\n";
        }

        $response = $this->parseResponse($output);

        if (!empty ($error)) {
            echo "error : $error\n";
            die("failed to request");
        }
        echo "Transaction-ID : " . $response["transactionId"] . "\n";
        return $response["json"];
    }

    public function PUT($uri, $data, $query = array())
    {
        $data_string = json_encode($data);

        $ch = curl_init();
        if (!$ch) {
            die ("Couldn't initialize a cURL handle");
        }
        curl_setopt($ch, CURLOPT_URL, $this->baseUrl . $uri . (empty($query) ? '' : '?' . $this->build_http_query($query)));
        curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
        curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "PUT");
        curl_setopt($ch, CURLOPT_POST, true);
        curl_setopt($ch, CURLOPT_POSTFIELDS, $data_string);
        curl_setopt($ch, CURLOPT_HEADER, true);
        curl_setopt($ch, CURLOPT_HTTPHEADER, $this->getHeader('PUT', $uri));

        $output = curl_exec($ch);
        $code = curl_getinfo($ch, CURLINFO_HTTP_CODE);
        $error = curl_error($ch);
        curl_close($ch);

        if (empty ($code)) {
            die ("No HTTP code was returned");
        } else {
            echo "Http Status : " . $code . "\n";
        }

        $response = $this->parseResponse($output);

        if (!empty ($error)) {
            echo "error : $error\n";
            die("failed to request");
        }
        echo "Transaction-ID : " . $response["transactionId"] . "\n";
        return $response["json"];
    }

    public function DOWNLOAD($url, $localpath)
    {
        $fp = fopen($localpath, "w");
        $ch = curl_init();
        curl_setopt($ch, CURLOPT_URL, $url);
        curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
        curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "GET");
        curl_setopt($ch, CURLOPT_HEADER, false);
        curl_setopt($ch, CURLOPT_HTTPHEADER, $this->getHeader("GET", "/report-download"));
        curl_setopt($ch, CURLOPT_FILE, $fp);
        curl_setopt($ch, CURLOPT_TIMEOUT, 120);

        $output = curl_exec($ch);
        $code = curl_getinfo($ch, CURLINFO_HTTP_CODE);
        $error = curl_error($ch);
        curl_close($ch);
        fclose($fp);

        if (empty ($code)) {
            die ("No HTTP code was returned");
        } else {
            echo "Http Status : " . $code . "\n";
        }

        if (!empty ($error)) {
            echo "error : $error\n";
            die("failed to request");
        }
    }
}

?>