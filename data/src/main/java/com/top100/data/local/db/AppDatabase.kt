package com.top100.data.local.db

import com.top100.data.local.db.model.AlbumEntity
import com.top100.data.local.db.model.GenreEntity
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import javax.inject.Inject

class AppDatabase @Inject constructor() {
    private var realm: Realm? = null
    fun dbInit(): Realm {
        if (realm == null) {
            val configuration = RealmConfiguration.Builder(
                setOf(
                    AlbumEntity::class,
                    GenreEntity::class
                )
            )
                .name(DB)
                .deleteRealmIfMigrationNeeded()
                .schemaVersion(0)
                .build()

            realm = Realm.open(configuration)
        }
        return realm as Realm
    }

    companion object {
        const val DB = "top100.db"
    }
}
