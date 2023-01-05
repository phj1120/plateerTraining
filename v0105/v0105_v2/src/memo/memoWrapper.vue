<template>
    <div>
        <MemoAdd @add="add"></MemoAdd>
        <MemoDisplay :words="words" @remove="remove"></MemoDisplay>
    </div>
</template>

<script setup>
import { ref } from 'vue';
import MemoAdd from './memoAdd.vue';
import MemoDisplay from './memoDisplay.vue';
const nextSequence = ref(3)
const words = ref([
    { "sequence": 0, "text": "AAA" },
    { "sequence": 1, "text": "BBB" },
    { "sequence": 2, "text": "CCC", }
])

const add = (text) => {
    words.value.push({ "sequence": nextSequence.value++, "text": text })

    text = ''
    console.log(text)
}

const handleClickAdd = (text) => {
    add(text)

}

const remove = (removeSequence) => {
    const result = words.value.filter(element => element.sequence !== removeSequence)
    words.value = result
}
</script>

<style lang="scss" scoped>

</style>