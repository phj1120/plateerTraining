<template>
    <div>
        <h1>memoWrapper</h1>
        <MemoAdd></MemoAdd>
        <MemoDisplay :words="words" @remove="remove"></MemoDisplay>
    </div>
</template>

<script setup>
import { reactive, ref } from 'vue';
import MemoAdd from './memoAdd.vue';
import MemoDisplay from './memoDisplay.vue';

const nextSequence = ref(3)

const words = reactive([
    { "sequence": 0, "text": "AAA" },
    { "sequence": 1, "text": "BBB" },
    { "sequence": 2, "text": "CCC", }
])

console.log(words);

const add = (text) => {
    arr.push(nextSequence.value++, text)
}

const remove = (removeSequence) => {
    const result = words.filter(element => element.sequence !== removeSequence)
    words = result
}
</script>

<style lang="scss" scoped>

</style>