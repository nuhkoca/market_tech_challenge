package com.techchallenge.data

import com.google.common.truth.Truth
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MarketimDomainMapperTest {

    @Mock
    lateinit var marketimDomainMapper: MarketimDomainMapper

    @Mock
    lateinit var responseRaw: ResponseRaw

    @Mock
    lateinit var response: Response

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun `marketim_domain_mapper_should_map_data_successfully`() {
        Mockito.`when`(marketimDomainMapper.invoke(responseRaw)).thenReturn(response)

        val expected = response

        Truth.assertThat(expected).isNotNull()
    }

    @Test
    fun `marketim_domain_mapper_should_not_map_data_successfully`() {
        Mockito.`when`(marketimDomainMapper.invoke(responseRaw)).thenReturn(null)

        Truth.assertThat(marketimDomainMapper.invoke(responseRaw)).isNull()
    }

    @Test
    fun `marketim_domain_mapper_should_match_data_with_given`() {
        Mockito.`when`(marketimDomainMapper.invoke(responseRaw)).thenReturn(response)

        val expected = response

        Truth.assertThat(marketimDomainMapper.invoke(responseRaw)).isEqualTo(expected)
    }

    @After
    fun tearDown() {
        // no-op
    }
}
