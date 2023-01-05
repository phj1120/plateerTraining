<template>
  {{word.str}}<button @click="() => remove(word.seq)"> remove </button>
</template>

<script setup>
 const emits = defineEmits(['change'])


</script>

<style scoped>

</style>