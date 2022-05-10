import request from '../utils/request'

export default {
  addUser(user) {
    return request({
      url: '/user',
      method: 'post',
      data: user
    })
  },

  deleteUser(id) {
    return request({
      url: `/user/${id}`,
      method: 'delete'
    })
  },

  deleteMoreUser(ids) {
    return request({
      url: '/user',
      method: 'delete',
      data: ids
    })
  },

  updateUser(user) {
    return request({
      url: `/user`,
      method: 'put',
      data: user
    })
  },

  findUserList(index,size, queryParam) {
    return request({
      url: `/user/${index}/${size}`,
      method: 'post',
      data: queryParam
    })
  },

  getUserInfo(id) {
    return request({
      url: `/user/${id}`,
      method: 'get'
    })
  }
}