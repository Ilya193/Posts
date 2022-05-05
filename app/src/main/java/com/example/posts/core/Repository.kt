package com.example.posts.core

import com.example.posts.data.posts.cache.PostsCacheDataSource
import io.realm.RealmObject

interface Repository<E : Abstract.DataObject> {
    suspend fun fetchData(): E

    abstract class Base<T : RealmObject,
            C : Abstract.CloudObject,
            D : Abstract.DataObject,
            E : Abstract.DataObject>(
        private val cacheDataSource: PostsCacheDataSource<D>,
        private val cloudMapper: Abstract.Mapper.Data<List<C>, List<D>>,
        private val cacheMapper: Abstract.Mapper.Data<List<T>, List<D>>
    ) : Repository<E> {
        override suspend fun fetchData(): E {
            return try {
                val cachedList = getCachedDataList()
                if (cachedList.isEmpty()) {
                    val cloudList = fetchCloudData()
                    val list = cloudMapper.map(cloudList)
                    cacheDataSource.save(list)
                    returnSuccess(list)
                } else {
                    returnSuccess(cacheMapper.map(cachedList))
                }
            } catch (e: Exception) {
                returnFail(e)
            }
        }

        protected abstract suspend fun fetchCloudData(): List<C>
        protected abstract fun getCachedDataList(): List<T>
        protected abstract fun returnSuccess(list: List<D>): E
        protected abstract fun returnFail(e: Exception): E
    }
}