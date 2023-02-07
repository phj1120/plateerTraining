<template>
  <v-form>
    <v-container>
      <v-row class="justify-center">
        <v-col cols="12" md="7">
          <v-text-field v-model="rolling.id" label="ID" readonly></v-text-field>
        </v-col>

        <v-col cols="12" md="7">
          <v-text-field v-model="rolling.title" label="Title" required></v-text-field>
        </v-col>

        <v-col cols="12" md="7">
          <v-text-field v-model="rolling.target" label="Target" required></v-text-field>
        </v-col>


        <v-col cols="12" md="7">
          <v-text-field v-model="rolling.wno" label="Writer" readonly></v-text-field>
        </v-col>

        <v-col cols="12" md="7">
          <v-text-field v-model="rolling.createDt" label="Create Date" readonly></v-text-field>
        </v-col>

        <RollingUploadComponent @addFile="addFile"></RollingUploadComponent>

        <v-col cols="12" md="7">
          <v-radio-group v-model="rollingInfo.fixFile">
            <v-row class="justify-center">
              <div class="ma-6" v-for="(preview,i) in previews" :key="i">
                <v-img class="ma-2" :src="preview.url" contain height="15vh" width="15vw"/>
                <v-row>
                  <v-radio :label="preview.name" :value="i"></v-radio>
                  <v-btn @click="clickRemoveBtn(i)">삭제</v-btn>
                </v-row>
              </div>
            </v-row>
          </v-radio-group>
        </v-col>


        <v-col cols="12" md="7">
          <v-btn class="ml-3" color="error" @click="clickDeleteBtn" style="float: right">DEL</v-btn>
          <v-btn color="success" @click="clickModifyBtn" style="float: right">MOD</v-btn>
        </v-col>


      </v-row>
    </v-container>
  </v-form>

  <v-dialog class="justify-center" v-model="dialog">
    <v-card style="margin: 0 auto; width: 50vw">
      <v-card-text>
        롤링페이퍼 {{ props.id }}번이 정상적으로 처리되었습니다.
      </v-card-text>
      <v-card-actions>
        <v-btn color="primary" block @click="handleClickDialog">Close</v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script setup>
import {deleteRolling, getRolling, modifyRolling} from "@/apis/rolling/RollingApis";
import {onMounted, ref, watch} from "vue";
import RollingUploadComponent from "@/components/rolling/RollingUploadComponent.vue";


const props = defineProps(['id'])
const emits = defineEmits(['handleMoveDetail', 'handleMoveList'])
const dialog = ref(false)
const rolling = ref({})

const rollingInfo = ref({id: null, title: null, target: null, fixFile: 0, files: []})
const previews = ref([])


const handleClickDialog = () => {
  dialog.value = !dialog.value
  emits('handleMoveList')
}

const getRollingOne = async () => {
  const res = await getRolling(props.id)

  rolling.value = res.data
}

const clickModifyBtn = async () => {
  rollingInfo.value.id = rolling.value.id
  rollingInfo.value.title = rolling.value.title
  rollingInfo.value.target = rolling.value.target

  await modifyRolling(rollingInfo.value)
  dialog.value = true
}

const clickDeleteBtn = async () => {
  await deleteRolling(props.id)
  dialog.value = true
}

onMounted(() => {
  getRollingOne()
})

watch(rollingInfo.value.files, async () => {
  console.log(rollingInfo.value)
  previews.value = []
  rollingInfo.value.files.forEach((file) => {
      const reader = new FileReader()
      reader.readAsDataURL(file)
      reader.onload = () => {
        previews.value.push({name: file.name, url: reader.result})
      }
    }
  )
})

const addFile = (files) => {
  for (let i = 0; i < files.length; i++) {
    rollingInfo.value.files.push(files[i])
  }
}

const clickRemoveBtn = (i) => {
  rollingInfo.value.files.splice(i, 1)

  // 썸네일을 삭제한 경우 첫번째 사진을 썸네일로 지정
  if (i === rollingInfo.value.fixFile) {
    rollingInfo.value.fixFile = 0
  }

  // 썸네일 이전 값을 삭제한 경우 썸네일 번호 재지정
  if (i < rollingInfo.value.fixFile) {
    rollingInfo.value.fixFile--
  }

}
</script>

<style scoped>

</style>
