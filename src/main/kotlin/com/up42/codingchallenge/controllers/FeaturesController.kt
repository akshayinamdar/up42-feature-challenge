package com.up42.codingchallenge.controllers

import com.up42.codingchallenge.controllers.model.Features
import com.up42.codingchallenge.exceptions.FeaturesNotFoundException
import com.up42.codingchallenge.services.FeatureService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class FeaturesController(@Autowired var featureService: FeatureService) {
    var logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @GetMapping("/features")
    fun getFeatures(): ResponseEntity<List<Features.Feature>> {
        return try {
            logger.info("Received request to get all features.")
            val features = featureService.getAllFeatures()
            logger.info("Returning ${features.size} features.")
            return ResponseEntity(features, HttpStatus.OK)
        } catch (ex: Exception) {
            logger.error("Error while getting all features", ex)
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("features/{featureId}/quicklook")
    fun getFeatureQuickLookByFeatureId(@PathVariable featureId: UUID): ResponseEntity<Any> {
        logger.info("Received request to get feature quicklook for id: $featureId.")
        val headers = HttpHeaders()
        headers.contentType = MediaType.IMAGE_PNG

        return try {
            val quicklook = featureService.getFeatureQuicklookById(featureId)
            logger.info("Returning quicklook for feature with id: $featureId.")
            ResponseEntity(quicklook, headers, HttpStatus.OK)
        } catch (e: FeaturesNotFoundException) {
            logger.warn("Feature with ID '$featureId' not found")
            ResponseEntity("Feature not found", HttpStatus.NOT_FOUND)
        } catch (e: Exception) {
            logger.error("Error retrieving quicklook for feature with ID '$featureId'", e)
            ResponseEntity("Error retrieving quicklook", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
}