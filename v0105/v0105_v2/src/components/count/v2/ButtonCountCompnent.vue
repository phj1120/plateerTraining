<template>
    <button @click="() => emits('change', 1)">+</button>
    <button @click="() => emits('change', -1)">-</button>
</template>

<script setup>
const emits = defineEmits(['change'])

</script>

<style lang="scss" scoped>

</style>