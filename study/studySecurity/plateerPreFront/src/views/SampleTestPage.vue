<template>
  <h1>Sample Test Page</h1>
  <br>
  <br>
  <v-btn @click="handleClickEx1">Ex1</v-btn>
  <br>
  <br>
  <v-btn @click="handleClickEx2">Ex2</v-btn>
  <br>
  <br>
  <v-btn @click="handleClickEx3">Ex3</v-btn>
</template>

<script setup>
  import authAxios from "@/util/authAxios";

  const handleClickEx1 = async () => {
    const res = authAxios.get(`http://localhost:8080/api/sample/ex1`)
    const data = res.data

    console.log(data)
  }

  const handleClickEx2 = async () => {
    const res = authAxios.get(`http://localhost:8080/api/sample/ex2`)
    const data = res.data

    console.log(data)
  }

  const handleClickEx3 = async () => {
    const res = authAxios.get(`http://localhost:8080/api/sample/ex3`)
    const data = res.data

    console.log(data)
  }
</script>

<style scoped>

</style>
