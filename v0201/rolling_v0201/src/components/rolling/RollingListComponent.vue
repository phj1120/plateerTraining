<template>
  <div>
    <v-row>
      <v-col cols="12">
        <v-btn class="ma-4" color="success" @click="emits('handleMoveAdd')">ADD</v-btn>
        <v-form class="ma-4 searchBox">
          <v-combobox class="searchTypeBox" label="Type" v-model="searchInfo.types" :items="typeList"
                      variant="underlined"></v-combobox>
          <v-text-field class="searchValueBox" v-model="searchInfo.keyword" label="Keyword" variant="underlined"
                        required></v-text-field>
          <v-btn @click="clickSearch()" variant="text" style="margin-top: 0.7em;">Search</v-btn>
        </v-form>
      </v-col>
    </v-row>
  </div>
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
    <v-pagination v-model="paginationInfo.pageNum" :show-first-last-page="true" :total-visible="paginationInfo.pageSize"
                  :length="paginationInfo.length" :start="paginationInfo.start"
                  @click="clickChangePage"></v-pagination>
    <br>
  </div>
</template>

<script setup>
import {getRollingList} from "@/apis/rolling/RollingApis";
import {ref} from "vue";

// pageSearch : {page: null, size:null, types: null, keyword: null}
const props = defineProps(['pageSearch'])
const emits = defineEmits(['handleMoveAdd', 'handleMoveDetail', 'handleChangePage', 'handleRollingSearch'])

const rollings = ref({})
const typeList = ref(['TITLE', 'TARGET'])
const paginationInfo = ref({pageNum: 1, pageSize: 10, length: null, start: 1})
const searchInfo = ref({types: props.pageSearch.types, keyword: props.pageSearch.keyword})

const clickSearch = () => {
  emits('handleRollingSearch', searchInfo.value)
}

const clickChangePage = () => {
  emits('handleChangePage', paginationInfo.value.pageNum)
}

const clickDetail = (id) => {
  emits('handleMoveDetail', id)
}

const getRollings = async () => {
  const data = await getRollingList(props.pageSearch)
  paginationInfo.value.pageNum = data.page
  paginationInfo.value.pageSize = data.size
  paginationInfo.value.length = data.last
  rollings.value = data.dtoList
}

getRollings()

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
