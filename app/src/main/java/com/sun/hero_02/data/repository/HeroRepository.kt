package com.sun.hero_02.data.repository

import com.sun.hero_02.data.model.ChampionsResponse
import com.sun.hero_02.data.model.Hero
import com.sun.hero_02.utils.DataResult

interface HeroRepository {
    /**
     * Local
     */

    /**
     * Remote
     */
    suspend fun getChampions() : DataResult<MutableList<Hero>>
}
