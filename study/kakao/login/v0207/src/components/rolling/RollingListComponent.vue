<template>
  <div>
    <v-row>
      <v-col cols="12">
        <v-btn class="ma-4" color="success" @click="emits('handleMoveAdd')">ADD</v-btn>
      </v-col>
    </v-row>
  </div>
  <v-table>
    <thead>
    <tr class="bg-grey-darken-2">
      <th class="text-center text-grey-lighten-2">ID</th>
      <th class="text-center text-grey-lighten-2">Image</th>
      <th class="text-center text-grey-lighten-2">Title</th>
      <th class="text-center text-grey-lighten-2">Target</th>
      <th class="text-center text-grey-lighten-2">Writer</th>
      <th class="text-center text-grey-lighten-2 w-1">Create Date</th>
      <th class="text-center text-grey-lighten-2 w-0"></th>
    </tr>
    </thead>
    <tbody>
      <tr class="he" v-for="rolling in rollings" :key="rolling.id" style="height: 4em">
        <td class="text-center">{{ rolling.id }}</td>
        <td class="text-center">
          <img class="mt-2" :src="getImagePath(rolling.imgSrc)" width="50" height="50" />
        </td>
        <td class="text-center">{{ rolling.title }}</td>
        <td class="text-center">{{ rolling.target }}</td>
        <td class="text-center">{{ rolling.writer }}</td>
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
import {getImagePath, getRollingList} from "@/apis/rolling/RollingApis";
  import {ref} from "vue";

  // pageSearch : {page: null, size:null, types: null, keyword: null}
  const props = defineProps(['pageSearch'])
  const emits = defineEmits(['handleMoveAdd', 'handleMoveDetail', 'handleChangePage', 'handleRollingSearch'])
  const paginationInfo = ref({pageNum: 1, pageSize: 10, length: null, start: 1})
  const rollings = ref({})

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
