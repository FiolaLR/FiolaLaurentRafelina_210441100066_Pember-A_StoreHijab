package com.example.storehijab.dataa.dao

import androidx.room.*
import com.example.storehijab.dataa.entity.pengguna

@Dao
interface penggunaDao {
    //getAll ambil semua data dari table user
    @Query("SELECT * FROM pengguna")
    fun getAll(): List<pengguna>

    //disini untuk memanggil/mengambil data yang dimana di ambil drai user id
    @Query("SELECT * FROM pengguna WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<pengguna>

    @Insert
    fun insertAll(vararg users: pengguna)

    @Delete
    fun delete(pengguna: pengguna)

    @Query("SELECT * FROM pengguna WHERE uid = :uid")
    fun get(uid: Int) : pengguna

    @Update
    fun update(pengguna: pengguna)
}