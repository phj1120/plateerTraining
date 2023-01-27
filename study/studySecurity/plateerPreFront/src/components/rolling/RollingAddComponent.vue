<template>
  <v-row>
    <v-col cols="12">
      <div>
        <v-form ref="form" v-model="rollingInfo.valid" lazy-validation class="formLength" enctype="multipart/form-data">
          <div>
            <v-card>
              <v-text-field v-model="rollingInfo.target" :counter="10" :rules="rollingInfo.nameRules" label="TARGET" required></v-text-field>
              <v-text-field v-model="rollingInfo.title" :rules="rollingInfo.titleRules" label="TITLE" required></v-text-field>
              <v-file-input multiple type="file" counter label="File input" v-model="files" @change="handleChangeFile"></v-file-input>
              <hr>
              <v-img v-for="(item,i) in uploadimageurl" :key="i" :src="item.url"
                     contain height="40vh" width="40vw" style="border: 2px solid black; margin-left:100px;"/>
            </v-card>
          </div>
          <br>
          <div class="center">
            <v-btn class="vbtn" color="primary" @click="handleClickAdd">작성하기</v-btn>
            <v-btn class="vbtn" :to="{ name: 'RollingList' }">목록으로</v-btn>
          </div>
        </v-form>
      </div>
    </v-col>
  </v-row>
</template>

<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
import axios from "axios";

  const files = ref()
  const rollingInfo = ref({
    nameRules: [
      (v) => !!v || "target is required",
      (v) => (v && v.length <= 10) || "target must be less than 10 characters",
    ],
    titleRules: [(v) => !!v || "title is required"],
  });

  const handleClickAdd = async () => { await axios.post(`http://localhost:8080/api/rolling/postRollingPaper`, rollingInfo.value) }

  const handleChangeFile = async ( file ) => {
    if (!file) { return }
    const formData = new FormData()

    files.value.forEach((item) => {
      formData.append('filelist', item)
      const reader = new FileReader()
      reader.onload = (e) => {
        uploadimageurl.value.push({url: e.target.result})
      }
      reader.readAsDataURL(item)
    })

    await axios.post(`http://localhost:8080/api/rolling/postRollingFile`, formData, {headers: {'Content-Type': 'multipart/form-data'}})
}
</script>

<style scoped>
  .formLength {
    width: 50vw;
  }

  .vbtn {
    float: right;
    margin-bottom: 1em;
    margin-right: 1em;
  }
</style>
