<template>
  <v-table class="mt-10">
    <tbody>
      <tr>
        <th class="text-center bg-grey-darken-2">ID</th>
        <td class="text-center">{{ rolling.id }}</td>
      </tr>

      <tr>
        <th class="text-center bg-grey-darken-2">Title</th>
        <td class="text-center">{{ rolling.title }}</td>
      </tr>

      <tr>
        <th class="text-center bg-grey-darken-2">Target</th>
        <td class="text-center">{{ rolling.target }}</td>
      </tr>

      <tr>
        <th class="text-center bg-grey-darken-2">Image</th>
        <td class="text-center">
          <v-row class="ma-2">
            <div style="margin: 0 auto">
              <img class="ma-2" v-for="img in rolling.imgSrcs" :src="getImagePath(img)" width="300" />
            </div>
          </v-row>
<!--          {{ rolling.imgSrcs }}-->
        </td>
      </tr>

      <tr>
        <th class="text-center bg-grey-darken-2">Writer</th>
        <td class="text-center">{{ rolling.writer }}</td>
      </tr>

      <tr>
        <th class="text-center bg-grey-darken-2">Create Date</th>
        <td class="text-center">{{ rolling.createDt }}</td>
      </tr>

      <tr>
        <th class="text-center"></th>
        <td class="text-center">
          <v-btn class="ma-4" color="success" @click="emits('handleMoveList')">List</v-btn>
          <v-btn class="ma-4" color="info" @click="emits('handleMoveModify')">MOD</v-btn>
        </td>
      </tr>
    </tbody>
  </v-table>
</template>

<script setup>
import {getImagePath, getRolling} from "@/apis/rolling/RollingApis";
  import {ref} from "vue";
  import {useRoute} from "vue-router";


  const rolling = ref({})
  const props = defineProps(['id'])
  const emits = defineEmits(['handleMoveModify', 'handleMoveList'])


  const getRollingOne = async () => {
    const res = await getRolling( props.id )
    rolling.value = res.data
    console.log(res.data)
  }


  getRollingOne()
</script>

<style scoped>
</style>
