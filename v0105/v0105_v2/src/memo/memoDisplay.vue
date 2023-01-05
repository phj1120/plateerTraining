<template>
    <ul>
        <li v-for="word in props.words" :key="word.sequence">
            {{ word.text }} <button @click="() => emits('remove', word.sequence)">x</button>
        </li>
    </ul>
</template>

<script setup>
const props = defineProps(['words'])
const emits = defineEmits(['remove'])
</script>

<style lang="scss" scoped>

</style>