package com.example.api_project

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.Update
import okhttp3.internal.platform.PlatformRegistry.applicationContext

@Dao
interface FactsDao {
    @Query("SELECT * FROM factentry")
    fun getAll(): List<FactEntry>

    @Query("SELECT * FROM factentry WHERE uid IN (:factIds)")
    fun loadAllByIds(factIds: IntArray): List<FactEntry>

    @Insert
    fun insertAll(vararg facts: FactEntry)


    @Update
    fun updateAll(vararg facts: FactEntry)

    @Insert
    fun insertNew(fact: FactEntry)

    @Delete
    fun delete(fact: FactEntry)
}
@Entity
data class FactEntry(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "text") val text: String?,
    @ColumnInfo(name = "translation") val translation: String?
)

@Database(entities = [FactEntry::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun factDao(): FactsDao
}


class DatabaseHelper() {

    var entry_list: List<FactEntry> = emptyList()
    val db = Room.databaseBuilder(
        applicationContext!!,
        AppDatabase::class.java, "database-name"
    ).allowMainThreadQueries().build()

    val FactDao = db.factDao()
    fun convert_and_add(fact: String, tr: String){
        var entry = FactEntry(0, fact, tr)
        entry_list += entry
        FactDao.insertNew(entry)
    }

    fun getFacts(): List<FactEntry> = FactDao.getAll()
    fun insertAll() = FactDao.insertAll(*entry_list.map { it }.toTypedArray())
    fun updateAll() = FactDao.updateAll(*entry_list.map { it }.toTypedArray())
}

val db: DatabaseHelper = DatabaseHelper()