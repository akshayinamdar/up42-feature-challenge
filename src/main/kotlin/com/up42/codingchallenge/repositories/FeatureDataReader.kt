package com.up42.codingchallenge.repositories

import com.up42.codingchallenge.controllers.model.Features


interface FeatureDataReader {
    fun dataReader(): List<Features.Feature>
}