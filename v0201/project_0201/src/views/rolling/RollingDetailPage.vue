<template>
  <BaseLayout>
    <RollingDetailComponent :id="props.id" @handleMoveModify="handleMoveModify"
                            @handleMoveList="handleMoveList"></RollingDetailComponent>
  </BaseLayout>
</template>

<script setup>
import BaseLayout from "@/layouts/rolling/BaseLayout.vue";
import RollingDetailComponent from "@/components/rolling/RollingDetailComponent.vue";
import {useRoute, useRouter} from "vue-router";

const props = defineProps(['id'])

const route = useRoute()
const router = useRouter()


const handleMoveList = () => {
  console.log(route.query)
  router.push({name: 'RollingListPage', query: route.query})
}

const handleMoveModify = () => {
  router.push({name: 'RollingModifyPage', query: route.query})
}
</script>

<style scoped>

</style>
