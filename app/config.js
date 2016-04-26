angular.module('config', [])

.constant('config', {
  ENV: 'production',
  debug: false,
  timezone: 'Asia/Seoul',
  swaggerJson: [
    'assets/json/ncc-heroes.json',
    'https://demo.searchad.naver.com/v2/api-docs?group=tool',
    'assets/json/atower.json',
    'assets/json/ncc-report.json',
    'assets/json/master-report.json', 
    'assets/json/ncc-keywordstool.json',
    'assets/json/estimate.json'
  ],
  i18n: {
    prefix: 'assets/i18n/locale-',
    suffix: '.json'
  },
  menus: ['guides', 'reference', 'samples', 'release-notes'],
  tags: {
    pascalCase: true,
    include: ['~[a-zA-Z]+~'],
    exclude: ['accesscontrol', 'advancedreportcontroller', 'apiapikey', 'apicustomerauth', 'apihistory', 'apikeys', 'apilicenses', 'apimyclientscontroller', 'auth', 'columncontroller', 'customer', 'customerauth', 'customerlinks', 'history', 'managercandidates', 'nccmanagedkeyword', 'l7~', 'basicerror~', '~endpoint', 'endpoint~', '~controller']
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
