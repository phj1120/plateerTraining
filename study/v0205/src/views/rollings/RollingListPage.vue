<template>
  <RollingLayout>
    <h2>RollingListPage</h2>
    <div :key="componentKey">
      <RollingListComponent :paging="paging" @moveDetail="moveDetail" @movePage="movePage"></RollingListComponent>
    </div>
  </RollingLayout>
</template>

<script setup>
import RollingLayout from "@/layouts/rolling/RollingLayout.vue";
import RollingListComponent from "@/components/rolling/RollingListComponent.vue";
import {useRoute, useRouter} from "vue-router";
import {ref} from "vue";


const router = useRouter()
const route = useRoute();

const componentKey = ref(0)
const paging = ref({page: route.query.page, size: route.query.size})


const moveDetail = (id) => {
  router.push({name: 'RollingDetail', params: {id: id}, query: paging.value})
}

// const pagination = ref({page: null, start: null, size: null, end: null})
const movePage = (pagination) => {
  paging.value.page = pagination.value.page
  paging.value.size = pagination.value.size
  // console.log('RollingListPage.movePage')
  // console.log(paging.value)

  router.push({name: 'RollingList', query: paging.value})
}

router.beforeEach(() => {
  componentKey.value++
})
</script>

<style scoped>

</style>
