<template>
    <input v-model="newWord" /> <button @click="() => emit('add', newWord)">+</button>
</template>

<script setup>
import { ref } from 'vue';

var newWord = ref("")
const emit = defineEmits(['add'])

</script>

<style lang="scss" scoped>

</style>