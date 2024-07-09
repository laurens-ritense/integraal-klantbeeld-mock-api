package com.ritense.mockapi.api

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.core.io.ClassPathResource
import org.springframework.util.FileCopyUtils
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.nio.charset.StandardCharsets
import java.util.UUID

@RestController
class ApiResource {
    @GetMapping("/thema")
    fun getThemas(): String {
        val resource = ClassPathResource("json-mock-data/themas.json")
        val file = resource.inputStream
        val content = FileCopyUtils.copyToByteArray(file)
        return String(content, StandardCharsets.UTF_8)
    }

    @GetMapping("/thema/{id}")
    fun getThema(@PathVariable id: UUID): String {
        val resource = ClassPathResource("json-mock-data/themas.json")
        val file = resource.inputStream
        val content = FileCopyUtils.copyToByteArray(file)
        val json = String(content, StandardCharsets.UTF_8)

        val mapper = jacksonObjectMapper()
        val thema = mapper.readValue<List<Thema>>(json).find { it.id == id }
            ?: throw NoSuchElementException("Thema with id $id not found")

        return mapper.writeValueAsString(thema)
    }

    @GetMapping("/klant")
    fun getKlanten(): String {
        val resource = ClassPathResource("json-mock-data/klanten.json")
        val file = resource.inputStream
        val content = FileCopyUtils.copyToByteArray(file)
        return String(content, StandardCharsets.UTF_8)
    }

    @GetMapping("/klant/{id}")
    fun getKlant(@PathVariable id: UUID): String {
        val resource = ClassPathResource("json-mock-data/klanten.json")
        val file = resource.inputStream
        val content = FileCopyUtils.copyToByteArray(file)
        val json = String(content, StandardCharsets.UTF_8)

        val mapper = jacksonObjectMapper()
        val klant = mapper.readValue<List<Klant>>(json).find { it.uuid == id }
            ?: throw NoSuchElementException("Klant with id $id not found")

        return mapper.writeValueAsString(klant)
    }

    @GetMapping("/persoon")
    fun getPersonen(): String {
        val resource = ClassPathResource("json-mock-data/personen.json")
        val file = resource.inputStream
        val content = FileCopyUtils.copyToByteArray(file)
        return String(content, StandardCharsets.UTF_8)
    }

    @GetMapping("/persoon/{bsn}")
    fun getPersoon(@PathVariable bsn: Long): String {
        val resource = ClassPathResource("json-mock-data/personen.json")
        val file = resource.inputStream
        val content = FileCopyUtils.copyToByteArray(file)
        val json = String(content, StandardCharsets.UTF_8)

        val mapper = jacksonObjectMapper()
        val klant = mapper.readValue<List<Persoon>>(json).find { it.bsn == bsn }
            ?: throw NoSuchElementException("Persoon with bsn $bsn not found")

        return mapper.writeValueAsString(klant)
    }

    @GetMapping("/voertuigen/persoon")
    fun getVoertuigen(): String {
        val resource = ClassPathResource("json-mock-data/voertuigen.json")
        val file = resource.inputStream
        val content = FileCopyUtils.copyToByteArray(file)
        return String(content, StandardCharsets.UTF_8)
    }

    @GetMapping("/voertuigen/persoon/{bsn}")
    fun getVoertuig(@PathVariable bsn: Long): String {
        val resource = ClassPathResource("json-mock-data/voertuigen.json")
        val file = resource.inputStream
        val content = FileCopyUtils.copyToByteArray(file)
        val json = String(content, StandardCharsets.UTF_8)

        val mapper = jacksonObjectMapper()
        val klant = mapper.readValue<List<Voertuig>>(json).find { it.eigenaar.bsn == bsn }
            ?: throw NoSuchElementException("Voertuig with bsn $bsn not found")

        return mapper.writeValueAsString(klant)
    }
}
