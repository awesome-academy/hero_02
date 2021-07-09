package com.sun.hero_02.data.repository.source

import com.sun.hero_02.data.model.ChampionsResponse
import com.sun.hero_02.data.model.Hero
import com.sun.hero_02.data.model.HeroDetail

interface HeroDataSource {

    interface Local {
    }

    interface Remote {
        suspend fun getChampions(): ChampionsResponse<Hero>

        suspend fun getChampionDetail(idHero: String): ChampionsResponse<HeroDetail>
    }
}
