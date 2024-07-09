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
    private val mapper = jacksonObjectMapper()

    @GetMapping("/thema")
    fun getThemas(): List<Thema> {
        val resource = ClassPathResource("json-mock-data/themas.json")
        val file = resource.inputStream
        val content = FileCopyUtils.copyToByteArray(file)
        return mapper.readValue<List<Thema>>(content)
    }

    @GetMapping("/thema/{id}")
    fun getThema(@PathVariable id: UUID): Thema {
        val resource = ClassPathResource("json-mock-data/themas.json")
        val file = resource.inputStream
        val content = FileCopyUtils.copyToByteArray(file)
        val json = String(content, StandardCharsets.UTF_8)

        return mapper.readValue<List<Thema>>(json).find { it.id == id }
            ?: throw NoSuchElementException("Thema with id $id not found")
    }

    @GetMapping("/klant")
    fun getKlanten(): List<Klant> {
        val resource = ClassPathResource("json-mock-data/klanten.json")
        val file = resource.inputStream
        val content = FileCopyUtils.copyToByteArray(file)
        return mapper.readValue<List<Klant>>(content)
    }

    @GetMapping("/klant/{id}")
    fun getKlant(@PathVariable id: UUID): Klant {
        val resource = ClassPathResource("json-mock-data/klanten.json")
        val file = resource.inputStream
        val content = FileCopyUtils.copyToByteArray(file)
        val json = String(content, StandardCharsets.UTF_8)

        return mapper.readValue<List<Klant>>(json).find { it.uuid == id }
            ?: throw NoSuchElementException("Klant with id $id not found")
    }

    @GetMapping("/persoon")
    fun getPersonen(): List<Persoon> {
        val resource = ClassPathResource("json-mock-data/personen.json")
        val file = resource.inputStream
        val content = FileCopyUtils.copyToByteArray(file)
        return mapper.readValue<List<Persoon>>(content)
    }

    @GetMapping("/persoon/{bsn}")
    fun getPersoon(@PathVariable bsn: Long): Persoon {
        val resource = ClassPathResource("json-mock-data/personen.json")
        val file = resource.inputStream
        val content = FileCopyUtils.copyToByteArray(file)
        val json = String(content, StandardCharsets.UTF_8)

        return mapper.readValue<List<Persoon>>(json).find { it.bsn == bsn }
            ?: throw NoSuchElementException("Persoon with bsn $bsn not found")
    }

    @GetMapping("/voertuigen/persoon")
    fun getVoertuigen(): List<Voertuig> {
        val resource = ClassPathResource("json-mock-data/voertuigen.json")
        val file = resource.inputStream
        val content = FileCopyUtils.copyToByteArray(file)
        return mapper.readValue<List<Voertuig>>(content)
    }

    @GetMapping("/voertuigen/persoon/{bsn}")
    fun getVoertuig(@PathVariable bsn: Long): Voertuig {
        val resource = ClassPathResource("json-mock-data/voertuigen.json")
        val file = resource.inputStream
        val content = FileCopyUtils.copyToByteArray(file)
        val json = String(content, StandardCharsets.UTF_8)

        return mapper.readValue<List<Voertuig>>(json).find { it.eigenaar.bsn == bsn }
            ?: throw NoSuchElementException("Voertuig with bsn $bsn not found")
    }
}
