package com.cognifide.cogboard.widget.type.sonarqube

import com.cognifide.cogboard.widget.type.sonarqube.versions.V5x
import com.cognifide.cogboard.widget.type.sonarqube.versions.V7x
import io.vertx.core.json.JsonObject

interface Version {

    fun getMeasureKey(): String
    fun getMetricKey(): String
    fun getStatusValueKey(): String
    fun getUrl(url: String, key: String, joinedMetrics: String): String
    fun getDashboardUrl(publicUrl: String, key: String, idNumber: Int): String
    fun getJson(responseBody: JsonObject): JsonObject
    fun getMetricValue(metric: JsonObject): Int

    companion object Test {
        fun getVersion(version: String) =
                if (version == "5.x") V5x()
                else V7x()
    }
}
