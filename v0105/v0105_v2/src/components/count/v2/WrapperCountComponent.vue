<template>
    <div>
        <DisplayCountComponent :count="count"></DisplayCountComponent>
    </div>
    <div>
        <ButtonCountCompnent @change="handleClickChange"></ButtonCountCompnent>
    </div>
</template>

<script setup>
import { reactive } from 'vue';
import ButtonCountCompnent from './ButtonCountCompnent.vue';
import DisplayCountComponent from './DisplayCountComponent.vue';

const count = reactive({ "number": 10 })

const change = (amont) => {
    count.number += amont
}

const handleClickChange = (amont) => {
    change(amont)
}

</script>

<style lang="scss" scoped>

</style>