import axios from 'axios'

export async function getVideoComment(videoId, limit) {
  try {
    const response = await axios.get(
      `http://ec2-13-124-116-59.ap-northeast-2.compute.amazonaws.com:8080/video/${videoId}/comments`,
      {
        params: { limit },
      },
    )
    console.log(response)
    return response.data
  } catch (error) {
    console.log(error)
    return null
  }
}
