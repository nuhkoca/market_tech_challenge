package com.techchallenge.data

import com.google.common.truth.Truth
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MarketimViewItemMapperTest {

    @Mock
    lateinit var marketimViewItemMapper: MarketimViewItemMapper

    @Mock
    lateinit var response: Response

    @Mock
    lateinit var responseViewItem: ResponseViewItem

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun `marketim_view_item_mapper_should_map_data_successfully`() {
        Mockito.`when`(marketimViewItemMapper.invoke(response)).thenReturn(responseViewItem)

        val expected = responseViewItem

        Truth.assertThat(expected).isNotNull()
    }

    @Test
    fun `marketim_view_item_mapper_should_not_map_data_successfully`() {
        Mockito.`when`(marketimViewItemMapper.invoke(response)).thenReturn(null)

        Truth.assertThat(marketimViewItemMapper.invoke(response)).isNull()
    }

    @Test
    fun `marketim_view_item_mapper_should_match_data_with_given`() {
        Mockito.`when`(marketimViewItemMapper.invoke(response)).thenReturn(responseViewItem)

        val expected = responseViewItem

        Truth.assertThat(marketimViewItemMapper.invoke(response)).isEqualTo(expected)
    }

    @After
    fun tearDown() {
        // no-op
    }
}
