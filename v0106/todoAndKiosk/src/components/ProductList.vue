<template>
<h2>Product List</h2>
<ul>
  <li v-for="product in props.products" :key = "product.id" @click="()=>emits('addCart', product)">
      <v-card
        class="mx-auto"
        max-width="344"
      >
        <v-img
          :src="product.url"
          height="200px"
          cover
        ></v-img>
        <v-card-title>
          {{product.name}} / {{product.price}}
        </v-card-title>
      </v-card>
  </li>
</ul>

</template>

<script setup>
const props = defineProps(['products'])
const emits = defineEmits(['addCart'])
</script>

<style scoped>

</style>
