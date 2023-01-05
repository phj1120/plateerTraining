<template>
    {{ evenOrOdd }}
</template>

<script setup>
import { computed } from 'vue';

const props = defineProps(["count"])
const evenOrOdd = computed(() => {
    if (props.count.number % 2 === 0)
        return "Even"
    return "Odd"
})
</script>

<style lang="scss" scoped>

</style>