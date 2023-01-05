<template>
  <div>{{ count.number }}</div>
  <button @click="add()">+</button>
  <button @click="minus()">-</button>
</template>

<script setup>
import { ref } from 'vue'
const count = ref({ number: 0 })

const add = () => {
  console.log(count.value.number)
  count.value.number++
}

const minus = () => {
  console.log(count.value.number)
  count.value.number--
}

</script>

<style scoped>

</style>