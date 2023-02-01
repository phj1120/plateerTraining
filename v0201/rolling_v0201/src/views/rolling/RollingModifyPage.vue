<template>
  <BaseLayout>
    <RollingModifyComponent :id="id" @handleMoveDetail="handleMoveDetail"
                            @handleMoveList="handleMoveList"></RollingModifyComponent>
  </BaseLayout>
</template>

<script setup>
import BaseLayout from "@/layouts/rolling/BaseLayout.vue";
import RollingModifyComponent from "@/components/rolling/RollingModifyComponent.vue";
import {useRoute, useRouter} from "vue-router";

const route = useRoute()
const router = useRouter()
const id = route.params.id

const handleMoveDetail = () => {
  router.push({name: 'RollingDetailPage', params: {id: id}})
}

const handleMoveList = () => {
  router.push({name: 'RollingListPage', query: route.query})
}
</script>

<style scoped>

</style>
