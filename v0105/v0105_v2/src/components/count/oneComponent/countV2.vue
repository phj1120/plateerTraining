<template>
  <div>{{ count.number }}</div>
  <button @click="change(1)">+</button>
  <button @click="change(-1)">-</button>
</template>

<script setup>
import { ref } from 'vue'
const count = ref({ number: 0 })

const change = (amount) => {
  console.log(count.value.number)
  count.value.number += amount
}

</script>

<style scoped>

</style>