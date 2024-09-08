package com.superheeyoung.movie.features.feed.data.mapper

import com.superheeyoung.movie.features.common.entity.BaseEntity
import com.superheeyoung.movie.features.common.entity.MovieFeedEntity
import com.superheeyoung.movie.features.common.entity.MovieResultEntity
import com.superheeyoung.movie.features.common.mapper.BaseEntityMapper
import com.superheeyoung.movie.features.common.network.MovieResultResponse
import com.superheeyoung.movie.features.feed.data.findGenreType
import javax.inject.Inject

class MovieMapper @Inject constructor() :
    BaseEntityMapper<List<MovieResultResponse>, List<MovieResultEntity>>() {
    override fun getSuccess(model: List<MovieResultResponse>?): BaseEntity.Success<List<MovieResultEntity>> {
        return model?.let {
            BaseEntity.Success(toSortingMovieResultEntity(it))
        } ?: BaseEntity.Success(entity = listOf())
    }

    override fun getFailure(error: Throwable): BaseEntity.Fail<List<MovieResultEntity>> {
        return BaseEntity.Fail(error)
    }
}

fun toSortingMovieResultEntity(target : List<MovieResultResponse>) : List<MovieResultEntity> {
    val genreSet = mutableSetOf<Int>().apply {
        addAll(target.flatMap { it.genreList })
    }
    return mutableListOf<MovieResultEntity>().also { entity ->
        genreSet.forEachIndexed { index, genreType ->
            target
                .filter { it.genreList.contains(genreType) }
                .let {
                    entity.add(
                        MovieResultEntity(
                            genreType = findGenreType(genreType),
                            movieEntities = toMovieFeedEntity(it)
                        )
                    )
                }
        }
    }
}

fun toMovieFeedEntity(target : List<MovieResultResponse>) : List<MovieFeedEntity> = with(target) {
    return map {
        MovieFeedEntity(
            it.id,
            "https://image.tmdb.org/t/p/w500${it.posterPath}",
            it.title,
            it.overview,
            it.voteAverage
        )
    }
}