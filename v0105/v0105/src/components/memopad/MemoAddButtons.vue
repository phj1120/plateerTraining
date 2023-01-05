<template>
  <h2>Count Buttons Component</h2>
  <div>
    <button @click="() => adds('add')"> add </button>
  </div>
</template>

<script setup>
 const adds = defineEmits(['add'])
</script>

<style scoped>

</style>