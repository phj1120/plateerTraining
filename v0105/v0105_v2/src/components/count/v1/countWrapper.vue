<template>
    <h1>Count Wrapper Component</h1>
    <CountDisplay v-bind:count="count"></CountDisplay>
    <CountButton v-on:change="change"></CountButton>

    <CountDisplay :count="count"></CountDisplay>
    <CountButton @change="change"></CountButton>
</template>

<script setup>
import { ref } from 'vue';
import CountButton from './countButton.vue';
import CountDisplay from './countDisplay.vue';

const count = ref({ number: 10 })

const change = (amount) => {
    console.log(count.value.number)
    count.value.number += amount
}
</script>

<style lang="scss" scoped>

</style>