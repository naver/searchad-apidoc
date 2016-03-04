angular.module('config', [])

.constant('config', {
  ENV: 'production',
  debug: false,
  timezone: 'Asia/Seoul',
  swaggerJson: ['http://10.113.217.209:8080/v2/api-docs?group=ncc', 'https://test-atower.searchad.naver.com/v2/api-docs', 'http://10.99.196.208:17000/v2/api-docs', 'assets/json/master-report.json'],
  i18n: {
    prefix: 'assets/i18n/locale-',
    suffix: '.json'
  },
  menus: ['guides', 'reference', 'samples'],
  tags: {
    pascalCase: true,
    exclude: ['accesscontrol', 'adextension', 'advancedreportcontroller', 'apiapikey', 'apicustomerauth', 'apihistory', 'apikeys', 'apimyclientscontroller', 'auth', 'columncontroller', 'customer', 'customerauth', 'customerlinks', 'estimate', 'history', 'label', 'managercandidates', 'nccmanagedkeyword', 'l7~', 'basicerror~', '~endpoint', 'endpoint~', '~controller']
  },
  definitions: {
    order: ['*', '~tm'],
    custom: {
      NccCampaign: {
        order: ['nccCampaignId', 'customerId', 'name', 'userLock', 'campaignTp', 'deliveryMethod', 'trackingUrl', 'trackingMode', 'usePeriod', 'periodStartDt', 'periodEndDt', 'delFlag', 'delTm', 'regTm', 'editTm']
      }
    }
  },
  operations: {
    order: ['list', 'get', 'create', 'update', 'delete', '*'],
    uriReplace: {
      '^\\/api': ''
    }
  }
})

;
