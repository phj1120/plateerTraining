<template>
  <v-row>
    <v-col cols="12">
      <v-btn class="ma-4" color="success" @click="clickAdd">ADD</v-btn>
      <v-form class="ma-4 searchBox">
        <v-combobox class="searchTypeBox" label="Type" v-model="searchBox.searchType" :items="searchBox.item"
                    variant="underlined"></v-combobox>
        <v-text-field class="searchValueBox" v-model="searchBox.searchValue" label="Keyword" variant="underlined"
                      required></v-text-field>
        <v-btn @click="clickSearchBtn" variant="text" style="margin-top: 0.7em;">Search</v-btn>
      </v-form>
    </v-col>
  </v-row>
  <v-table>
    <thead>
    <tr>
      <th class="text-center">ID</th>
      <th class="text-center">Title</th>
      <th class="text-center">Target</th>
      <th class="text-center">Writer</th>
      <th class="text-center">Image</th>
      <th class="text-center">Create Date</th>
      <th class="text-center"></th>
    </tr>
    </thead>
    <tbody>
    <tr v-for="rolling in rollings" :key="rolling.id">
      <td class="text-center">{{ rolling.id }}</td>
      <td class="text-center">{{ rolling.title }}</td>
      <td class="text-center">{{ rolling.target }}</td>
      <td class="text-center">{{ rolling.writer }}</td>
      <td class="text-center">{{ rolling.imgSrc }}</td>
      <td class="text-center">{{ rolling.createDt }}</td>
      <td>
        <v-btn color="info" @click="clickDetail(rolling.id)">Detail</v-btn>
      </td>
    </tr>
    </tbody>
  </v-table>

  <div class="text-center">
    <v-pagination v-model="pageInfo.pageNum"
                  :show-first-last-page="true" :total-visible="pageInfo.pageSize"
                  :length="pageInfo.length" :start="pageInfo.start"
                  @click="clickPageNumBtn"></v-pagination>
    <br>
  </div>
</template>

<script setup>
import {getRollingList} from "@/apis/rolling/RollingApis";
import {onMounted, ref} from "vue";

const props = defineProps(['page'])
const emits = defineEmits(['handleMoveAdd', 'handleMoveDetail', 'handleChangePage', 'handleSearchList'])

const data = ref({page: null, size: null, last: null})
// const pageInfo = ref({pageNum: 1, pageSize: 10, length: 10, start: 1})
const pageInfo = ref({pageNum: 1, pageSize: 1, length: null, start: 1})
const searchBox = ref({item: ['TITLE', 'TARGET'], searchType: 'TITLE', searchValue: ''})
const rollings = ref({})

const pageDTO = ref({page:null, size:null})
const searchDTO = ref({types:null, keyword:null})

const getRollings = async () => {
  data.value = await getRollingList(pageDTO, searchDTO)
  pageInfo.value.pageNum = data.value.page
  pageInfo.value.pageSize = data.value.size
  pageInfo.value.length = data.value.last
  rollings.value = data.value.dtoList
}

const clickSearchBtn = async () => {
  emits('handleSearchList', pageInfo.value.pageNum, pageInfo.value.pageSize)
}

const clickPageNumBtn = async () =>{
  emits('handleChangePage', pageInfo.value.pageNum, pageInfo.value.pageSize)
}

const clickDetail = (id) => {
  emits('handleMoveDetail', id)
}

const clickAdd = () => {
  emits('handleMoveAdd')
}

onMounted(async () => {
  await getRollings()
})
</script>

<style scoped>
.searchBox {
  display: flex;
  width: 25vw;
  float: right;
}

.searchTypeBox {
  width: 6vw;
}

.searchValueBox {
  width: 12vw;
}
</style>
