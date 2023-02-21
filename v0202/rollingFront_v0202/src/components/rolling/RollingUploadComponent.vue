<template>
  <v-col cols="12" md="7">
  <v-file-input multiple type="file" label="File input" v-model="files" @change="handleChangeFile(files)"
                accept="image/*" ></v-file-input>
<!--    <v-img v-for="(item,i) in uploadimageurl" :key="i" :src="item.url" contain height="40vh" width="40vw" style="border: 2px solid black; margin-left:100px;"/>-->
  </v-col>
    <v-dialog v-model="dialog">
      <v-card>
        <v-card-text>
          {{ count }}개의 파일이 실패하였습니다.
        </v-card-text>
        <v-card-actions>
          <v-btn color="primary" block @click="dialog = false">Close Dialog</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>

</template>

<script setup>
  import {ref} from "vue";
  const emits = defineEmits(['setFileInfos'])
  const files = ref([])
  const fileInfos = ref([])
  const dialog = ref(false)
  let count = 0
  const handleChangeFile = ( files ) => {
    if ( !files ) { return }

    files.forEach(( file ) => {

      if(!fileRule(file)){
        count++
        return
      }
      const reader = new FileReader()
      reader.readAsDataURL(file)
      reader.onload = () => {
        fileInfos.value.push({name: file.name, url: reader.result})
      }
    })

    emits('setFileInfos', fileInfos.value)
    if(count > 0){
      dialog.value = true

    }
  }

  const fileRule = (file)=>{
    const ableExt = ['jpg','png','gif','jpeg']
    const ext = file.name.split('.').pop().toLowerCase()
    if(!ableExt.includes(ext)){
      return false
    }

  return true

  }



  // const handleClickAdd = async () => {
  //   const formData = new FormData()
  //   files.value.forEach((item) => {
  //     formData.append('filelist', item)
  //   })
  //   if (formData.get('filelist')) {
  //     await axios.post(`http://armysseung.iptime.org:3258/api/rolling/postRollingFile`, formData, {headers: {'Content-Type': 'multipart/form-data'}})
  //   }
  //   await axios.post(`http://armysseung.iptime.org:3258/api/rolling/postRollingPaper`, rollingInfo.value)
  //
  // }
</script>

<style scoped>

</style>
