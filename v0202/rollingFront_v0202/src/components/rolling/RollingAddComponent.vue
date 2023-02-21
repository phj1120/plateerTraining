<template>
  <v-form>
    <v-container>
      {{ rollingInfo}}
      <v-row class="justify-center">
        <v-col cols="12" md="7">
          <v-text-field v-model="rollingInfo.title" label="Title" required></v-text-field>
        </v-col>
        <v-col cols="12" md="7">
          <v-text-field v-model="rollingInfo.target" label="Target" required></v-text-field>
        </v-col>

        <RollingUploadComponent @setFileInfos="setFileInfos"></RollingUploadComponent>

        <v-col cols="12" md="7">
          <v-radio-group v-model="rollingInfo.fixFile">
            <v-row class="justify-center">
              <div class="ma-6" v-for="(item,i) in rollingInfo.fileInfos" :key="i">
                <v-img class="ma-2" :src="item.url" contain height="15vh" width="15vw"/>
                <v-row>
                  <v-radio :label="item.name" :value="i"></v-radio>
                  <v-btn @click="clickRemoveBtn(i)">삭제</v-btn>
                </v-row>
              </div>
            </v-row>
          </v-radio-group>
        </v-col>

        <v-col cols="12" md="7">
          <v-btn class="ma-xl-auto" color="success" @click="handleClickAdd" style="float: right">ADD</v-btn>
        </v-col>
      </v-row>
    </v-container>
  </v-form>

</template>
<script setup>
  import {ref} from "vue";
  import {addRolling} from "@/apis/rolling/rollingApis";
  import RollingUploadComponent from "@/components/rolling/RollingUploadComponent.vue";


  const rollingInfo = ref({title: null, target: null, fileInfos: [], fixFile: 0})
  const emits = defineEmits(['handleMoveList'])


  const clickRemoveBtn = (i) => {
    rollingInfo.value.fileInfos.pop(i)
  }

  const handleClickAdd = async () => {
    await addRolling(rollingInfo.value)
    emits('handleMoveList')
  }

  const setFileInfos = (files) => {
    console.log(files)
    rollingInfo.value.fileInfos = files
  }
</script>

<style scoped>

</style>
