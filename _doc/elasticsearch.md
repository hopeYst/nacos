PUT /xbom-package
{
  "mappings": {
    "packaging": {
      "properties": {
        "id":{
          "type":"keyword"
        },
        "name":{
          "type":"text"
        }
      }
    }
  }
}
PUT /xbom-manufacturer
{
  "mappings": {
    "manufacturer": {
      "properties": {
        "id":{
          "type":"keyword"
        },
        "name":{
          "type":"text"
        },
        "url":{
          "type": "text"
        }
      }
    }
  }
}
PUT /xbom-product
{
  "mappings": {
    "product":{
      "properties": {
        "id":{
          "type": "keyword"
        },
        "dkNumber":{
          "type": "text"
        },
        "mfgNumber":{
          "type": "text"
        },
        "description":{
          "type": "text"
        },
        "manufacturerId":{
          "type": "long"
        },
        "packagingId":{
          "type": "long"
        },
        "marketplaceStatusId":{
          "type": "text"
        },
        "extendedDescription":{
          "type": "text"
        },
        "categoryId":{
          "type": "long"
        },
        "fee":{
          "type": "text"
        }
      }
    }
  }
}