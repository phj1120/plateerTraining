<template>
  <h3>Rolling List Component</h3>
  <div>
    <v-table>
      <thead>
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>썸네일</th>
        <th>생성일</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="rolling in rollings" :key="rolling.id" @click="handleClickRolling(rolling.id)">
        <td>{{ rolling.id }}</td>
        <td>{{ rolling.title }}</td>
        <td>{{ rolling.writer }}</td>
        <td><img :src="getImagePath(rolling.imgSrc)"/></td>
        <td>{{ rolling.createDt }}</td>
      </tr>
      </tbody>
    </v-table>

    <div class="text-center">
      <v-pagination
        v-model="pagination.page"
        :length="pagination.last"
        @click="handleClickPageNum"
      ></v-pagination>
    </div>
  </div>
</template>

<script setup>
import {ref} from "vue";
import {getRollings} from "@/api/rollingApi";
import {getImagePath} from "@/api/fileApi";

const pagination = ref({page: null, start: null, end: null})
const rollings = ref([])

const {paging} = defineProps(['paging'])
const emits = defineEmits(['movePage', 'moveDetail'])

const getRollingList = async () => {
  // console.log('RollingListComponent.getRollingList')
  // console.log(paging)
  const data = await getRollings(paging)
  rollings.value = data.dtoList

  pagination.value.start = data.start
  pagination.value.page = data.page
  pagination.value.end = data.end
  pagination.value.last = data.last
}
getRollingList()

const handleClickPageNum = () => {
  emits('movePage', pagination)
}

const handleClickRolling = (id) => {
  emits('moveDetail', id)
}
</script>

<style scoped>
</style>
