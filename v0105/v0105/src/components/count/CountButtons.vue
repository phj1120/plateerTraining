<template>
  <h2>Count Buttons Component</h2>

  <div>
    <button @click="() => emits('change', 1)">INC</button>
    <button @click="() => emits('change', -1)">DEC</button>
  </div>

</template>

<script setup>
 const emits = defineEmits(['change'])
</script>

<style scoped>

</style>