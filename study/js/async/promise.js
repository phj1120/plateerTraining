// 1. Producer
// 정상 resolve
// 에러 reject
const promise = new Promise((resolve, reject)=>{
    // Promise 가 생성 될 때 넘겨준 executor 가 바로 실행 됨
    console.log('start')
    // 파일 읽기, 네트워크 처리 시 비동기로 실행
    setTimeout(()=>{
        // resolve('park') // 성공
        reject(new Error('err')) // 실패
    }, 2000)
})

// 2. Consumers : then, catch, finally
promise.then((value)=>{
    console.log(value)
}).catch((err)=>{
    console.log(err)
})
.finally(()=>{
    console.log('finally')
})


// 3. Promise chaning
const fetchNumber = new Promise((resolve, reject)=>{
    setTimeout(()=>{resolve(1)}, 1000);
})

// then 에서는 promise 를 전달해도 되고 값을 전달해도 됨
fetchNumber
    .then(num=>num*2)
    .then(num=>num*3)
    .then(num=>{
        return new Promise((resolve, reject) =>{
            setTimeout(()=>resolve(num-1) ,1000)
        })
    })
    .then(num=>console.log(num))