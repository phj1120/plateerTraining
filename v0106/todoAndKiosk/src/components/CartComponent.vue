<template>
  <h2>Cart List</h2>
  <ul>
    <li v-for="stock in props.cart" :key="stock.item.id">
      {{ stock.item.name }}
      <v-btn @click="()=>emits('change', stock.item.id, 1)">+</v-btn>
      <v-btn @click="()=>emits('change',stock.item.id, -1)">-</v-btn>
    </li>
  </ul>
  <hr/>
  {{total}}
</template>

<script setup>
import {computed} from "vue";

const props = defineProps(['cart'])
const emits = defineEmits(['change'])

const total = computed(() => {
  let sum = 0

  for (let stock of props.cart) {
    sum += stock.item.price * stock.qty
  }

  return sum
})
</script>

<style scoped>

</style>
