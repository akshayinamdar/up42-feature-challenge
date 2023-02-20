package com.up42.codingchallenge.services

import com.up42.codingchallenge.controllers.model.Features
import com.up42.codingchallenge.repositories.FeatureDataReader
import org.apache.tomcat.util.codec.binary.Base64
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import java.util.UUID


@Service
class FeatureService(@Autowired @Qualifier("resourceDataReader") var featureDataReader: FeatureDataReader) {
    var logger: Logger = LoggerFactory.getLogger(this.javaClass)

    fun getAllFeatures(): List<Features.Feature> {
        return featureDataReader.dataReader()
    }

    fun getFeatureQuicklookById(searchId: UUID): ByteArray {
        val imageByteArray = Base64.decodeBase64(getFeatureById(searchId)?.properties?.quicklook!!)
        logger.debug("Image Byte array for a given id is $imageByteArray")
        return imageByteArray
    }

    fun getFeatureById(searchId: UUID): Features.Feature? =
        getAllFeatures().firstOrNull { it.id == searchId }
}
