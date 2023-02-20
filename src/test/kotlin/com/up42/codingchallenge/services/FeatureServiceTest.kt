package com.up42.codingchallenge.services

import com.up42.codingchallenge.controllers.model.Features
import com.up42.codingchallenge.exceptions.FeaturesNotFoundException
import com.up42.codingchallenge.repositories.FeatureDataReader
import org.codehaus.groovy.runtime.DefaultGroovyMethods.every
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import java.util.*

internal class FeatureServicesTest {
    val mockRepository = Mockito.mock(FeatureDataReader::class.java)
    val featureService = FeatureService(mockRepository)

    @Test
    fun `should execute the method dataReader()`() {
        featureService.getAllFeatures()
        Mockito.verify(mockRepository).dataReader();
    }

    @Test
    fun `expect base64 string for valid feature id`() {
        val testUUID = UUID.fromString("39c2f29e-c0f8-4a39-a98b-deed547d6aea")

        val testFeature: List<Features.Feature> = listOf(
            Features.Feature(
                Features.Feature.Properties(
                    UUID.fromString("39c2f29e-c0f8-4a39-a98b-deed547d6aea"),
                    null,
                    null,
                    "aVZCT1J3MEtHZ29BQUFBTlNVaEVVZ0FBQUJnQUFBQVlDQVlBQUFEZ2R6MzRBQUFBQkhOQ1NWUUlDQWdJZkFoa2lBQUFBQWx3U0ZsekFBQUFwZ0FBQUtZQjNYMy9PQUFBQUJsMFJWaDBVMjltZEhkaGNtVUFkM2QzTG1sdWEzTmpZWEJsTG05eVo1dnVQQm9BQUFOQ1NVUkJWRWlKdFpaUGJCdEZGTVovTTd1YlhkdGRiMXhTRnllaWxCYXB5U1ZVOGg4T29GYW9vRlNxaWloSVZJcFFCS2NpNktFZzlRNkg5a292SUhvQ0lWUUpKQ0tFMUVORmpuQWdjYVNHQzZyRW54QndBMDRUeDQzdDJGbnZEQWZqa05pYnhnSHhuV2IyZS91OTkyYmVlN3RDYTAwWUZzZmZla0ZZK25VekZ0alcwTHJ2alJYckNESUFhUExsVzBuSEwwU3NadFZvYUY5OG1McngzcGRoT3FMdFlQSENoYWhaY1lZTzdLdlBGeHZSbDVYUHAxc04zYWRXaUQxWkFxRDZYWUsxYi9kdkU1SVdyeVR0MnVkTEZlZHdjMSs5a0xwK3ZiYnBvRGgrNlRrbHhCZUFpOVRMMHRhZVdwZG1aelFEcnkwQWNPK2pRMTJSeW9ocXFvWW9vOFJEd0pyVStxWGtqV3RmaThYeHQ1OEJkUXV3UXM5cUMvYWZMd0N3OHRuUWJxWUFQc2d4RTFTNkYzRUFJWHV4Mm9RRkttMGloTXNPRjcxZEhZeCtmM05ORDY4Z2hDdTFZSW9lUFBRTjFwR1JBQmtKNkJ1czk2Q3V0UlpNeWRUbCtUdnVpUlcxbTNuMGVEbDB2UlBjRXlzcWRYbitqc1FQc3JITXF1R2VYRWFZNFlrNHd4V2NZNVYvOXNjcU9NT1ZVRnRoYXR5VHk4UXlxd1ora0RVUktvTVd4TktyMkVlcVZLY1ROT2FqcUtvQmdPRTI4VTR0ZFFsNXA1YndDdzdCV3F1YVpTekFQbHdqbGl0aEp0cDNwVEltU3FRUnJiMlo4UEhHaWdENFJadU5YNkpZajZ3ajdPNFRGTGJDTy9Nbi9tOFIraDZyWVNVYjNla29rUlk2Zi9ZdWtBck45NzlqY1crVi9TOGcwZVQvTjNWTjNrVHFXYlE0MjhtOS84azBQLzFhSWhGMzZQY2NFbDZFaE9jQVVDclhLWlhYV1MzWEtkMnZjL1RSQkc5TzVFTEMxN01tV3ViRDJuS2hVS1phMjZCYTIrRDNQKzQvTU5DRndnNTlvV1ZlWWhremdOL0pEUjhkZUtCb0Q3WStsakVqR1owc29zWFZUdmJjNlJIaXJyMnJlTnkxT1hkNnBKc1ErZ3FqazhWV0ZZbUhyd0J6Vy9uK3VNUEZpUndIQjJJN2loOGNpSEZ4SWtkLzNPbWs1dENEVjF0KzJuTnU1c3h4cERGTngraHVOaFZUMy96TUR6OHVzWEMzZGRhSEJqMUdIai9BczA4ZndUUzdLdDFIQlRteU4yOXZkd0F3Ky93YndMVk9KM3VBRDF3aS9kVUg3UWVpNjZQZnl1Umo0SWs5aXMraGdsZmJrYmZSM2NuWm03Y2hsVVdMZHdtcHJ0Q29oWDRIVXRsT2NRakxZQ3UrZnpHSkgyUVJLdlAzVU56OGJXazFxTXhqR1RPTVRoWjNrdmdMSTVBekZmbzM3OVVBQUFBQVNVVk9SSzVDWUlJPQ=="
                ),
                UUID.fromString("39c2f29e-c0f8-4a39-a98b-deed547d6aea"),
                1558155148786,
                1558155148786,
                1558155173785,
                "Sentinel-1A",
                "aVZCT1J3MEtHZ29BQUFBTlNVaEVVZ0FBQUJnQUFBQVlDQVlBQUFEZ2R6MzRBQUFBQkhOQ1NWUUlDQWdJZkFoa2lBQUFBQWx3U0ZsekFBQUFwZ0FBQUtZQjNYMy9PQUFBQUJsMFJWaDBVMjltZEhkaGNtVUFkM2QzTG1sdWEzTmpZWEJsTG05eVo1dnVQQm9BQUFOQ1NVUkJWRWlKdFpaUGJCdEZGTVovTTd1YlhkdGRiMXhTRnllaWxCYXB5U1ZVOGg4T29GYW9vRlNxaWloSVZJcFFCS2NpNktFZzlRNkg5a292SUhvQ0lWUUpKQ0tFMUVORmpuQWdjYVNHQzZyRW54QndBMDRUeDQzdDJGbnZEQWZqa05pYnhnSHhuV2IyZS91OTkyYmVlN3RDYTAwWUZzZmZla0ZZK25VekZ0alcwTHJ2alJYckNESUFhUExsVzBuSEwwU3NadFZvYUY5OG1McngzcGRoT3FMdFlQSENoYWhaY1lZTzdLdlBGeHZSbDVYUHAxc04zYWRXaUQxWkFxRDZYWUsxYi9kdkU1SVdyeVR0MnVkTEZlZHdjMSs5a0xwK3ZiYnBvRGgrNlRrbHhCZUFpOVRMMHRhZVdwZG1aelFEcnkwQWNPK2pRMTJSeW9ocXFvWW9vOFJEd0pyVStxWGtqV3RmaThYeHQ1OEJkUXV3UXM5cUMvYWZMd0N3OHRuUWJxWUFQc2d4RTFTNkYzRUFJWHV4Mm9RRkttMGloTXNPRjcxZEhZeCtmM05ORDY4Z2hDdTFZSW9lUFBRTjFwR1JBQmtKNkJ1czk2Q3V0UlpNeWRUbCtUdnVpUlcxbTNuMGVEbDB2UlBjRXlzcWRYbitqc1FQc3JITXF1R2VYRWFZNFlrNHd4V2NZNVYvOXNjcU9NT1ZVRnRoYXR5VHk4UXlxd1ora0RVUktvTVd4TktyMkVlcVZLY1ROT2FqcUtvQmdPRTI4VTR0ZFFsNXA1YndDdzdCV3F1YVpTekFQbHdqbGl0aEp0cDNwVEltU3FRUnJiMlo4UEhHaWdENFJadU5YNkpZajZ3ajdPNFRGTGJDTy9Nbi9tOFIraDZyWVNVYjNla29rUlk2Zi9ZdWtBck45NzlqY1crVi9TOGcwZVQvTjNWTjNrVHFXYlE0MjhtOS84azBQLzFhSWhGMzZQY2NFbDZFaE9jQVVDclhLWlhYV1MzWEtkMnZjL1RSQkc5TzVFTEMxN01tV3ViRDJuS2hVS1phMjZCYTIrRDNQKzQvTU5DRndnNTlvV1ZlWWhremdOL0pEUjhkZUtCb0Q3WStsakVqR1owc29zWFZUdmJjNlJIaXJyMnJlTnkxT1hkNnBKc1ErZ3FqazhWV0ZZbUhyd0J6Vy9uK3VNUEZpUndIQjJJN2loOGNpSEZ4SWtkLzNPbWs1dENEVjF0KzJuTnU1c3h4cERGTngraHVOaFZUMy96TUR6OHVzWEMzZGRhSEJqMUdIai9BczA4ZndUUzdLdDFIQlRteU4yOXZkd0F3Ky93YndMVk9KM3VBRDF3aS9kVUg3UWVpNjZQZnl1Umo0SWs5aXMraGdsZmJrYmZSM2NuWm03Y2hsVVdMZHdtcHJ0Q29oWDRIVXRsT2NRakxZQ3UrZnpHSkgyUVJLdlAzVU56OGJXazFxTXhqR1RPTVRoWjNrdmdMSTVBekZmbzM3OVVBQUFBQVNVVk9SSzVDWUlJPQ=="
            )
        )
        Mockito.`when`(mockRepository.dataReader()).thenReturn(testFeature)

        val dataByteArray: ByteArray = featureService.getFeatureQuicklookById(testUUID)

        assert(dataByteArray.isNotEmpty())
    }
}