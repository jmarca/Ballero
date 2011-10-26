package com.cldellow.ballero.data

import xml.{XML, NodeSeq}

case class AuthResponse (
  auth_token: Option[String],
  signing_key: Option[String]
)

case class OAuthCredential (
  auth_token: String,
  signing_key: String
)

case class Needle(
  comment: String,
  gaugeMetric: BigDecimal,
  gaugeUS: Option[BigDecimal],
  kind: String,
  lengthDecimal: Option[BigDecimal],
  lengthString: Option[String]
)

case class LocalYarnStore(
  address: String,
  city: String,
  latitude: BigDecimal,
  longitude: BigDecimal,
  name: String,
  phone: String,
  shop_email: Option[String],
  site: String,
  twitter_id: Option[String],
  url: String,
  zip: String
)

case class ShopResponse(
  shops: List[LocalYarnStore]
)
