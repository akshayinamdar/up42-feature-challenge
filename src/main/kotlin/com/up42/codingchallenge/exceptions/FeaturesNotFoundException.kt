package com.up42.codingchallenge.exceptions

import com.up42.codingchallenge.constants.FeatureConstants

class FeaturesNotFoundException() : Exception(FeatureConstants.FEATURES_NOT_FOUND)