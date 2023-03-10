package com.up42.codingchallenge.repositories.impl


import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Service

import com.up42.codingchallenge.constants.FeatureConstants
import com.up42.codingchallenge.controllers.model.Features
import com.up42.codingchallenge.exceptions.FeaturesNotFoundException
import com.up42.codingchallenge.repositories.FeatureDataReader


@Service
@Qualifier("resourceDataReader")
class ResourceFeatureDataReader : FeatureDataReader {
    override fun dataReader(): List<Features.Feature> {
        return ClassPathResource(FeatureConstants.SOURCE_DATA_JSON).file
            .readText()
            .let { jsonString -> jacksonObjectMapper().readValue<List<Features>>(jsonString) }
            .flatMap { it.features }
            .map {
                it.apply {
                    id = properties?.id
                    timestamp = properties?.timestamp
                    beginViewingDate = properties?.acquisition?.beginViewingDate
                    endViewingDate = properties?.acquisition?.endViewingDate
                    missionName = properties?.acquisition?.missionName
                }
            }
            .ifEmpty {
                throw FeaturesNotFoundException()
            }
    }
}